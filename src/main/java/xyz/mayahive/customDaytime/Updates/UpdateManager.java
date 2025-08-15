package xyz.mayahive.customDaytime.Updates;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UpdateManager {

    private final Plugin plugin;
    private final String pluginID;

    /**
     * Check for plugin updates from Modrinth API.
     *
     * @param plugin The plugin instance.
     * @param pluginID The Modrinth project id.
     */
    public UpdateManager(Plugin plugin, String pluginID) {
        this.plugin = plugin;
        this.pluginID = pluginID;

        checkUpdates();
    }

    public void checkUpdates() {

        // Try to open connection to the Modrinth API
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.modrinth.com/v2/project/" + pluginID + "/version"))
                    .timeout(java.time.Duration.ofSeconds(10))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse the JSON response
            JsonArray jsonResponse = JsonParser.parseString(response.body()).getAsJsonArray();

            if (!jsonResponse.isEmpty()) {
                // Get the latest version from the first object in the array
                JsonObject latestVersionObj = jsonResponse.get(0).getAsJsonObject();
                String latestVersion = latestVersionObj.get("version_number").getAsString();

                // Compare with the current plugin version
                if (!plugin.getPluginMeta().getVersion().equals(latestVersion)) {
                    Bukkit.getLogger().info("A new version of " + plugin.getName() + " is available: " + latestVersion + ".");

                    // Try to get the first download URL
                    JsonArray filesArray = (latestVersionObj.getAsJsonArray("files"));

                    // Get the download URL
                    String downloadURL = filesArray.get(0).getAsJsonObject().get("url").getAsString();

                    if (downloadURL != null) {
                        Bukkit.getLogger().info("You can download it here: " + downloadURL);
                    } else {
                        Bukkit.getLogger().info("No download URL or files available for the latest version.");
                        Bukkit.getLogger().info("Please, check manually for updates.");
                    }

                } else {
                    Bukkit.getLogger().info("You are using the latest version of " + plugin.getName() + ".");
                }

            } else {
                Bukkit.getLogger().info("No version data found for " + plugin.getName() + " on Modrinth.");
                Bukkit.getLogger().info("Please, check manually for updates.");
            }

        } catch (Exception e) {
            Bukkit.getLogger().info("Could not check for update: " + e.getMessage());
        }
    }

}
