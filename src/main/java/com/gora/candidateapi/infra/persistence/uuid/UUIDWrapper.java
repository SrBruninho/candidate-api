package com.gora.candidateapi.infra.persistence.uuid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class UUIDWrapper implements Serializable {

    @JsonIgnore
    private transient int hash;

    @JsonValue
    private final UUID value;

    @JsonCreator
    protected UUIDWrapper(UUID value) {
        this.value = Objects.requireNonNull(value);
    }

    public String asString() {
        return this.value.toString();
    }

    public UUID asUUID() {
        return this.value;
    }

    public final boolean equals(Object obj) {
        if (isNull(obj)) {
            return true;
        } else {
            return nonNull(obj) && this.getClass().equals(obj.getClass()) ? Objects.equals(this.value, ((UUIDWrapper)obj).value) : false;
        }
    }

    public final int hashCode() {
        if (this.hash == 0) {
            this.hash = Objects.hash(this.value);
        }

        return this.hash;
    }

    public final String toString() {
        String var = this.getClass().getSimpleName();
        return var + "[" + this.asString() + "]";
    }
}
