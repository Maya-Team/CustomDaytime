# 🌞 Custom Daytime Plugin 🌙

[![Downloads](https://img.shields.io/modrinth/dt/C7YliNqw?logo=modrinth&logoColor=white&style=for-the-badge)](https://modrinth.com/project/custom-daytime)
[![Latest Release](https://img.shields.io/github/v/release/SeedimV/CustomDaytime?logo=modrinth&logoColor=white&style=for-the-badge)](https://modrinth.com/project/custom-daytime)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg?style=for-the-badge)](https://github.com/SeedimV/CustomDaytime?tab=GPL-3.0-1-ov-file#readme)

Customize Minecraft's day/night cycle and experience smoother nights with this lightweight Paper plugin!

## ✨ Features

- **🕒 Configurable Day & Night Lengths**  
  Set the duration of Minecraft's day and night in **minutes** via the config. Accepts decimal values for precise timings (e.g., `0.5` for 30 seconds).

- **🌙 Fast-forward Night While Sleeping**  
  Instead of instantly skipping the night, time will **smoothly accelerate** when enough players sleep, creating a more immersive experience.

- **⚙️ Easy-to-Use Config**  
  All values are adjustable in the `config.yml` file:
  ```yaml
  # Length of the daytime cycle in minutes
  dayLengthMinutes: 10.0

  # Length of the nighttime cycle in minutes
  nightLengthMinutes: 10.0

  # Length of night fast forwarding in seconds
  nightFastForwardSeconds: 5.0

## 📥 Installation

1. Download the latest .jar from the releases page.

2. Place the .jar file in your server’s plugins folder.

3. Start your server to generate the default config.

4. Adjust the config.yml to your preferred day/night lengths and fast-forward speed.

5. Restart or reload the server to apply changes.

## ⚡ Usage

- The plugin works **automatically** once installed.

- Sleeping mechanics are replaced with the fast-forward system. Players no longer instantly skip the night.

- Config values are flexible, so you can create ultra-short or ultra-long days and nights.

## 📝 Configuration Options

| Option                    | Description                                        | Default        |
|---------------------------|----------------------------------------------------|----------------|
| `dayLengthMinutes`        | Duration of the day in minutes                     | 10.0 (minutes) |
| `nightLengthMinutes`      | Duration of the night in minutes                   | 10.0 (minutes) |
| `nightFastForwardSeconds` | Time it takes to fast-forward night while sleeping | 5.0 (seconds)  |

## 📜 License
This plugin is licensed under the [GNU General Public License v3.0](https://github.com/SeedimV/CustomDaytime/blob/master/LICENSE). You are free to use, modify, and distribute the plugin, but any derivative works must also be licensed under the same terms.

## 🌐 Author
Created by **Seedim**
- GitHub: https://github.com/SeedimV

- Modrinth: https://modrinth.com/user/SeedimV

- Buy Me a Coffee: https://buymeacoffee.com/seedim
