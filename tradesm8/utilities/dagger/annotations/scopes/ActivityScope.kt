package com.app.tradesm8.utilities.dagger.annotations.scopes

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Scope
@Documented
@Retention(RetentionPolicy.CLASS)
annotation class ActivityScope()
