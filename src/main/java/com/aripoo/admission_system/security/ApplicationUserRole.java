package com.aripoo.admission_system.security;



import com.google.common.collect.Sets;

import java.util.Set;

public enum AplicationUserRole{
    STUDENT(Sets.newHashSet()),
    TEACHER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(ApplicationUserPermission.COURSE_READ,
            ApplicationUserPermission.COURSE_WRITE,
            ApplicationUserPermission.STUDENT_READ,
            ApplicationUserPermission.STUDENT_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    AplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
