package com.x.blas.githubexplorer.dagger.binder

import dagger.MapKey
import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy
import javax.xml.transform.OutputKeys.METHOD
import kotlin.reflect.KClass

/**
 * Created by blasius.n.puspika on 27/09/20.
 */

@MapKey
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class SubcomponentKey(val value: KClass<*>)