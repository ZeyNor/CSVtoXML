<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<Contacts>
    <#list contacts as contact>
    <Contact>
        <username>${contact.userName}</username>
        <firstname>${contact.firstName}</firstname>
        <lastname>${contact.lastName}</lastname>
        <email>${contact.email}</email>
        <roles>
            <#list contact.roles as role>
                <role>${role}</role>
            </#list>
        </roles>
    </Contact>
    </#list>
</Contacts>


