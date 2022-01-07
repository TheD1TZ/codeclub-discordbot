package me.ditz.codeclubbot;

public enum Roles {
    JAVA_ROLE("922517574837764127"),
    JAVASCRIPT_ROLE("922517601618378762"),
    PYTHON_ROLE("922517618131370024"),
    CS_ROLE("922517651572523029"),
    KOTLIN_ROLE("922517686536245278"),
    CPP_ROLE("922517853880598599"),
    PHP_ROLE("922563225332092938"),
    HTML_ROLE("922643665338376193"),
    LINUX_ROLE("928072813686964276"),
    SERVERS_ROLE("928072931525922916"),
    RUBY_ROLE("928073856873271377"),



    INTRODUCED_ROLE("928080110341472407"),
    MEMBER_ROLE("922874948018651166"),

    END("end");


    private final String roles;
    Roles(String roles ) {
        this.roles = roles;
    }

    public final String getRole() {
        return this.roles;
    }

}
