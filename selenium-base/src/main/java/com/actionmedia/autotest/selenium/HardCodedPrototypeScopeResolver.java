package com.actionmedia.autotest.selenium;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

public class HardCodedPrototypeScopeResolver implements ScopeMetadataResolver {
    @Override
    public ScopeMetadata resolveScopeMetadata(final BeanDefinition definition) {
        final ScopeMetadata metadata = new ScopeMetadata();
        metadata.setScopeName(SCOPE_PROTOTYPE);
        return metadata;
    }
}

