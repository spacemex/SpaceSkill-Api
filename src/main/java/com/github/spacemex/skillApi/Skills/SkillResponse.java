package com.github.spacemex.skillApi.Skills;

public class SkillResponse {

    public enum ResponseType {
        SUCCESS(1),
        FAILURE(2),
        NOT_IMPLEMENTED(3),
        OTHER(4);

        private final int id;

        ResponseType(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    private final double exp;
    private final int level;
    private final ResponseType type;
    private final String error;

    public SkillResponse(double exp, int level, ResponseType type, String error) {
        this.exp = exp;
        this.level = level;
        this.type = type;
        this.error = error != null ? error : ""; // Handle null error cases
    }

    public double getExp() {
        return exp;
    }

    public int getLevel() {
        return level;
    }

    public ResponseType getType() {
        return type;
    }

    public String getError() {
        return error;
    }

    public boolean isSuccess() {
        return type == ResponseType.SUCCESS;
    }
}