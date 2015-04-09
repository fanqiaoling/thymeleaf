/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.aurora.context;

import java.util.Locale;

import org.thymeleaf.aurora.engine.IModelFactory;
import org.thymeleaf.aurora.engine.ModelFactory;
import org.thymeleaf.aurora.templatemode.TemplateMode;
import org.thymeleaf.util.Validate;

/**
 *
 * @author Daniel Fern&aacute;ndez
 * @since 3.0.0
 * 
 */
public class TemplateProcessingContext implements ITemplateProcessingContext {

    private final ITemplateEngineContext templateEngineContext;
    private final String templateName;
    private final TemplateMode templateMode;
    private final IModelFactory modelFactory;
    private final Locale locale;
    private final IVariablesMap variablesMap;


    public TemplateProcessingContext(
            final ITemplateEngineContext templateEngineContext,
            final String templateName, final TemplateMode templateMode,
            final Locale locale, final IVariablesMap variablesMap) {

        super();

        Validate.notNull(templateEngineContext, "Template Engine Context cannot be null");
        Validate.notNull(templateName, "Template Name cannot be null");
        Validate.notNull(templateMode, "Template Mode cannot be null");
        Validate.notNull(locale, "Locale cannot be null");
        Validate.notNull(variablesMap, "Variables map cannot be null");

        this.templateEngineContext = templateEngineContext;
        this.templateName = templateName;
        this.templateMode = templateMode;
        this.locale = locale;
        this.variablesMap = variablesMap;
        this.modelFactory =
                new ModelFactory(
                        this.templateMode, this.templateEngineContext.getTextRepository(),
                        this.templateEngineContext.getAttributeDefinitions(), this.templateEngineContext.getElementDefinitions());

    }


    public ITemplateEngineContext getTemplateEngineContext() {
        return this.templateEngineContext;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public TemplateMode getTemplateMode() {
        return this.templateMode;
    }

    public IModelFactory getModelFactory() {
        return this.modelFactory;
    }

    public Locale geLocale() {
        return this.locale;
    }

    public IVariablesMap getVariables() {
        return this.variablesMap;
    }

}
