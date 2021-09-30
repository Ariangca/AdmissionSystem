package com.aripoo.admission_system.security;



import com.google.common.collect.Sets;

import java.util.Set;

public enum AplicationUserRole{
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(AplicationUserPermission.COURSE_READ,
            AplicationUserPermission.COURSE_WRITE,
            AplicationUserPermission.STUDENT_READ,
            AplicationUserPermission.STUDENT_WRITE));

    private final Set<AplicationUserPermission> permissions;

    AplicationUserRole(Set<AplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
