beans = {
    customPropertyEditorRegistrar(com.webapp.CustomPropertyEditorRegistrar) {
        messageSource = ref('messageSource')
    }
    userDetailsService(com.webapp.ExtUserDetailsService)
}
