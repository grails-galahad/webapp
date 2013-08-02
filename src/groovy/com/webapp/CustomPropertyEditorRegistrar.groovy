package com.webapp

import java.text.SimpleDateFormat
import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.beans.PropertyEditorRegistrar
import org.springframework.beans.PropertyEditorRegistry
import org.springframework.context.i18n.LocaleContextHolder as LCH

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
    
    def messageSource
    
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        def format = messageSource.getMessage('datetimepicker.date.format', null, null, LCH.getLocale())
        registry.registerCustomEditor(Date, new CustomDateEditor(new SimpleDateFormat(format), true))
    }
}
