package com.company;

import java.io.Serializable;

public interface Identifiable extends Serializable {
    Long getId();
    void setId(Long id);
}
