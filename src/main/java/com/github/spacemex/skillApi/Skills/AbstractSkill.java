package com.github.spacemex.skillApi.Skills;

import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractSkill implements Skill {

    private final String name;
    private boolean enabled;
    private final Map<NamespacedKey, Boolean> playerSkills;

    public AbstractSkill(String name) {
        this.name = name;
        this.enabled = true; // Default to enabled
        this.playerSkills = new HashMap<>();
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String format(double exp) {
        return String.format("%,.2f", exp);
    }

    @Override
    public boolean hasSkill(OfflinePlayer player, NamespacedKey skillKey) {
        return playerSkills.getOrDefault(skillKey, false);
    }

    @Override
    public boolean addSkill(OfflinePlayer player, NamespacedKey skillKey) {
        return playerSkills.put(skillKey, true) == null; // Returns true if the key was not present previously
    }

    @Override
    public boolean removeSkill(OfflinePlayer player, NamespacedKey skillKey) {
        return playerSkills.remove(skillKey) != null; // Returns true if the key was present before removal
    }

    @Override
    public SkillResponse removeExp(OfflinePlayer player, double exp) {
        double currentExp = getExp(player);
        if (currentExp >= exp) {
            setExp(player, currentExp - exp);
            return new SkillResponse(getExp(player), getLevel(player), SkillResponse.ResponseType.SUCCESS, "");
        } else {
            return new SkillResponse(currentExp, getLevel(player), SkillResponse.ResponseType.FAILURE, "Not enough experience to remove.");
        }
    }

    @Override
    public SkillResponse removeLevel(OfflinePlayer player, int level) {
        int currentLevel = getLevel(player);
        if (currentLevel >= level) {
            setLevel(player, currentLevel - level);
            return new SkillResponse(getExp(player), getLevel(player), SkillResponse.ResponseType.SUCCESS, "");
        } else {
            return new SkillResponse(getExp(player), currentLevel, SkillResponse.ResponseType.FAILURE, "Not enough levels to remove.");
        }
    }

    @Override
    public SkillResponse addExp(OfflinePlayer player, double exp) {
        setExp(player, getExp(player) + exp);
        return new SkillResponse(getExp(player), getLevel(player), SkillResponse.ResponseType.SUCCESS, "");
    }

    @Override
    public SkillResponse addLevel(OfflinePlayer player, int level) {
        setLevel(player, getLevel(player) + level);
        return new SkillResponse(getExp(player), getLevel(player), SkillResponse.ResponseType.SUCCESS, "");
    }

    @Override
    public abstract boolean hasExp(OfflinePlayer player, int exp);

    @Override
    public abstract boolean hasLevel(OfflinePlayer player, int level);

    @Override
    public abstract double getExp(OfflinePlayer player);

    @Override
    public abstract int getLevel(OfflinePlayer player);

    protected abstract void setExp(OfflinePlayer player, double exp);

    protected abstract void setLevel(OfflinePlayer player, int level);
}