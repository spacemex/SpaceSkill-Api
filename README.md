# SpaceSkill-Api - A Comprehensive API for Managing Skills in Bukkit Plugins

[![Java CI with Maven](https://github.com/spacemex/SpaceSkill-Api/actions/workflows/maven.yml/badge.svg)](https://github.com/spacemex/SpaceSkill-Api/actions/workflows/maven.yml)
[![](https://jitpack.io/v/spacemex/SpaceSkill-Api.svg)](https://jitpack.io/#spacemex/SpaceSkill-Api)

### SpaceSkill-Api is a powerful and flexible API designed to simplify the creation and management of skills in Bukkit plugins.

## How to include the API

### With Maven:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.github.spacemex</groupId>
        <artifactId>SpaceSkill-Api</artifactId>
        <version>1.0</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

### With Gradle:

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    compileOnly "com.github.spacemex:SpaceSkill-Api:1.0"
}
```

**Note:** Replace `1.0` with the actual version number you are using.

## Why SpaceSkill-Api?

SpaceSkill-Api aims to provide a centralized system for skill management, making it easier for developers to create, use, and extend skills in their plugins. SpaceSkill-Api offers:

* An easy-to-use interface for defining skills.
* A base abstract class to simplify skill implementation.
* Powerful utility classes for handling experience and levels.
* Extensibility for adding custom functionality.

## License

SpaceSkill-Api is distributed under the MIT License. This means you are free to use, modify, and distribute it as long as you include the original license information.

## Building

SpaceSkill-Api includes all the necessary libraries to build from the current branch.

## Implementing SpaceSkill-Api

Implementing SpaceSkill-Api is straightforward. Below is an example of how to create a custom skill and hook into the API.

### Example Plugin

## Or A More Refined Example Plugin: [https://github.com/spacemex/SpaceSkill-ApiExamplePlugin](https://github.com/spacemex/SpaceSkillApiExamplePlugin)

```java
package com.example.skillplugin;

import com.github.spacemex.skillApi.Skills.*;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {

    private SkillManager skillManager;

    @Override
    public void onEnable() {
        // Initialize your SpaceSkill-Api and SkillManager here
        skillManager = new SkillManager();
        skillManager.registerSkill(new MiningSkill());

        getLogger().info(String.format("[%s] Enabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }

    @Override
    public void onDisable() {
        getLogger().info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            getLogger().info("Only players are supported for this Example Plugin.");
            return true;
        }

        Player player = (Player) sender;
        Skill miningSkill = skillManager.getSkill("Mining");

        if (command.getLabel().equals("check-skill")) {
            double exp = miningSkill.getExp(player);
            int level = miningSkill.getLevel(player);
            sender.sendMessage(String.format("You have %s experience and are level %d in Mining.", exp, level));
            return true;
        } else {
            return false;
        }
    }

    public SkillManager getSkillManager() {
        return skillManager;
    }
}
```

### Creating a Custom Skill

```java
package com.example.skillplugin;

import com.github.spacemex.skillApi.Skills.AbstractSkill;
import org.bukkit.OfflinePlayer;

import java.util.HashMap;
import java.util.Map;

public class MiningSkill extends AbstractSkill {

    private final Map<OfflinePlayer, Double> playerExp;
    private final Map<OfflinePlayer, Integer> playerLevels;

    public MiningSkill() {
        super("Mining");
        this.playerExp = new HashMap<>();
        this.playerLevels = new HashMap<>();
    }

    @Override
    public boolean hasExp(OfflinePlayer player, int exp) {
        return getExp(player) >= exp;
    }

    @Override
    public boolean hasLevel(OfflinePlayer player, int level) {
        return getLevel(player) >= level;
    }

    @Override
    public double getExp(OfflinePlayer player) {
        return playerExp.getOrDefault(player, 0.0);
    }

    @Override
    public int getLevel(OfflinePlayer player) {
        return playerLevels.getOrDefault(player, 0);
    }

    @Override
    protected void setExp(OfflinePlayer player, double exp) {
        playerExp.put(player, exp);
    }

    @Override
    protected void setLevel(OfflinePlayer player, int level) {
        playerLevels.put(player, level);
    }

    @Override
    public double getExpToLevel(int level) {
        return level * 100.0; // Example: each level requires 100 exp points
    }
}
```

## Conclusion

SpaceSkill-Api provides a robust platform for skill management in Bukkit plugins. For detailed documentation and further examples, please visit the [GitHub repository](https://github.com/spacemex/SpaceSkill-Api).

Feel free to open issues or contribute to the repository! Happy coding!
