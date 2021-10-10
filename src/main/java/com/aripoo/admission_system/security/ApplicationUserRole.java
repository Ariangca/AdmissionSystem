package com.aripoo.admission_system.security;



import com.google.common.collect.Sets;

import java.util.Set;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet(ApplicationUserPermission.STUDENT_READ,
            ApplicationUserPermission.RESULT_READ)),
    TEACHER(Sets.newHashSet(ApplicationUserPermission.COURSE_READ,
            ApplicationUserPermission.COURSE_WRITE,
            ApplicationUserPermission.TEACHER_READ,
            ApplicationUserPermission.TEACHER_WRITE,
            ApplicationUserPermission.RESULT_READ,
            ApplicationUserPermission.RESULT_WRITE,
            ApplicationUserPermission.STUDENT_READ,
            ApplicationUserPermission.STUDENT_WRITE)),

    ADMIN(Sets.newHashSet(ApplicationUserPermission.COURSE_READ,
            ApplicationUserPermission.COURSE_WRITE,
            ApplicationUserPermission.TEACHER_READ,
            ApplicationUserPermission.TEACHER_WRITE,
            ApplicationUserPermission.RESULT_READ,
            ApplicationUserPermission.RESULT_WRITE,
            ApplicationUserPermission.STUDENT_READ,
            ApplicationUserPermission.STUDENT_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
