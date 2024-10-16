package com.github.spacemex.skillApi;

import com.github.spacemex.skillApi.Skills.Skill;

import java.util.HashMap;
import java.util.Map;

/**
 * SkillManager is responsible for managing and providing access to registered skills.
 */
public class SkillManager {

    private final Map<String, Skill> skills;

    public SkillManager() {
        this.skills = new HashMap<>();
    }

    /**
     * Registers a new skill.
     * @param skill The skill to register.
     */
    public void registerSkill(Skill skill) {
        skills.put(skill.getName(), skill);
    }

    /**
     * Retrieves a registered skill by its name.
     * @param name The name of the skill.
     * @return The skill if found, otherwise null.
     */
    public Skill getSkill(String name) {
        return skills.get(name);
    }

    /**
     * Checks if a skill is registered.
     * @param name The name of the skill.
     * @return True if the skill is registered, otherwise false.
     */
    public boolean isSkillRegistered(String name) {
        return skills.containsKey(name);
    }

    /**
     * Unregisters a skill by its name.
     * @param name The name of the skill.
     */
    public void unregisterSkill(String name) {
        skills.remove(name);
    }

    /**
     * Gets a collection of all registered skills.
     * @return A collection of all skills.
     */
    public Map<String, Skill> getAllSkills() {
        return new HashMap<>(skills);
    }
}