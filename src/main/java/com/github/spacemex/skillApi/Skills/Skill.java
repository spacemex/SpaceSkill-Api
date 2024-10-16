package com.github.spacemex.skillApi.Skills;

import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;

public interface Skill {

    /**
     * Checks whether the skill is enabled.
     *
     * @return true if the skill is enabled, otherwise false
     */
    boolean isEnabled();

    /**
     * Retrieves the name of the skill.
     *
     * @return the name of the skill
     */
    String getName();

    /**
     * Formats the given experience value.
     *
     * @param exp the experience value to format
     * @return the formatted experience value as a String
     */
    String format(double exp);

    /**
     * Checks if the specified player has the required amount of experience.
     *
     * @param player the player whose experience is to be checked
     * @param exp the amount of experience to check for
     * @return true if the player has the specified amount of experience, otherwise false
     */
    boolean hasExp(OfflinePlayer player, int exp);

    /**
     * Checks to see if the player has the specified level.
     *
     * @param player the player to check
     * @param level the level to check for
     * @return true if the player has the specified level, otherwise false
     */
    boolean hasLevel(OfflinePlayer player, int level);

    /**
     * Retrieves the experience points of the specified player.
     *
     * @param player the player whose experience points are to be retrieved
     * @return the experience points of the specified player
     */
    double getExp(OfflinePlayer player);

    /**
     * Retrieves the skill level of the specified player.
     *
     * @param player the player whose skill level is to be retrieved
     * @return the skill level of the specified player
     */
    int getLevel(OfflinePlayer player);

    /**
     * Retrieves the experience points required to reach the specified level.
     *
     * @param level the level for which the required experience points are to be retrieved
     * @return the required experience points to reach the specified level
     */
    double getExpToLevel(int level);

    /**
     * Removes the specified amount of experience points from the player.
     *
     * @param player the player whose experience points are to be removed
     * @param exp    the experience points to remove
     * @return a SkillResponse indicating the result
     */
    SkillResponse removeExp(OfflinePlayer player, double exp);

    /**
     * Removes the specified number of levels from the player.
     *
     * @param player the player whose levels are to be removed
     * @param level  the number of levels to remove
     * @return a SkillResponse indicating the result
     */
    SkillResponse removeLevel(OfflinePlayer player, int level);

    /**
     * Adds the specified amount of experience points to the player.
     *
     * @param player the player whose experience points are to be added
     * @param exp    the experience points to add
     * @return a SkillResponse indicating the result
     */
    SkillResponse addExp(OfflinePlayer player, double exp);

    /**
     * Adds the specified number of levels to the player.
     *
     * @param player the player whose levels are to be added
     * @param level  the number of levels to add
     * @return a SkillResponse indicating the result
     */
    SkillResponse addLevel(OfflinePlayer player, int level);

    /**
     * Checks if the player has the specified skill.
     *
     * @param player   the player to check
     * @param skillKey the skill key
     * @return true if the player has the specified skill, otherwise false
     */
    boolean hasSkill(OfflinePlayer player, NamespacedKey skillKey);

    /**
     * Adds the specified skill to the player.
     *
     * @param player   the player to add the skill to
     * @param skillKey the skill key
     * @return true if the skill was successfully added, otherwise false
     */
    boolean addSkill(OfflinePlayer player, NamespacedKey skillKey);

    /**
     * Removes the specified skill from the player.
     *
     * @param player   the player to remove the skill from
     * @param skillKey the skill key
     * @return true if the skill was successfully removed, otherwise false
     */
    boolean removeSkill(OfflinePlayer player, NamespacedKey skillKey);
}