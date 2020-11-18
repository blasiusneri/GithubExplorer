GithubExplorer - Modularization Journey
=======================================

GithubExplorer developed using monolith architecture where only consist of single module, an app module

Test run application before doing modularization
Requirement: Github Account

Generate Access Token in Github (https://github.com/settings/tokens)
1. Click button "Generate new token"
2. Type note in note field
3. Click on the user check box (only use user related API)
4. Click Generate Token in bottom of the page
5. Copy token to ACCESS_TOKEN

Let's try the apps, it consist of two page
1. Main page
2. Search User page


Let's start to modularized the project:
1. Right click on the project folder and create new module
2. Select Android Library for new module
3. Set :base as name for the module
4. Invalid date and restart the IDE
5. Base module will shown on the project tree


Chapter 1 (setting the build.gradle)
//MODULARIZED - 1.01 Add two below plugin in build.gradle(:base)
apply plugin: 'kotlin-android-extensions'
apply plugin: 'kotlin-kapt'

//MODULARIZED - 1.02 Move all dependencies used in base to base module

//MODULARIZED - 1.03 Remove all dependencies that already declared in base using api only except annotationProcessor and kapt, make it available in both module
for example, put below dependencies in both build.gradle
annotationProcessor "com.google.dagger:dagger-android-processor:${rootProject.ext.google.daggerVersion}"
annotationProcessor ....
kapt "com.google.dagger:dagger-android-processor:${rootProject.ext.google.daggerVersion}"
kapt ....

//MODULARIZED - 1.04 add base module to app module
implementation project(":base")

Chapter 2 (Implementation)
//MODULARIZED - 2.01 create base application and extend this to AppComponent
open class BaseApplication : MultiDexApplication()

//MODULARIZED - 2.02 Create BaseComponent
interface BaseComponent : AndroidInjector<BaseApplication> {

@Module
//MODULARIZED - 2.03 Move NetworkModule to base but keep the GithubService Provider in app module, so create new GithubServiceModule.kt for GithubService Provider
class NetworkModule {


//MODULARIZED - 2.04 Create new module for provide GithubService and put it in app module
@Module
class GithubServiceModule {

    @Provides
    fun provideGithubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }
}

//MODULARIZED - 2.06 set NetworkModule as module used in BaseComponent
@Component(modules = [NetworkModule::class])

//MODULARIZED - 2.07 Exposed Retrofit to be used in service in BaseComponent
fun retrofit(): Retrofit

//MODULARIZED - 2.08 add BaseComponent so retrofit can supplied to AppComponent
dependencies = [BaseComponent::class]

//MODULARIZED - 2.09 create base component attribute so child class (AppApplication.kt) can get the it as companion
lateinit var baseComponent: BaseComponent

//MODULARIZED - 2.10 Declare baseComponent and inject it
baseComponent = DaggerBaseComponent.builder().applicationContext(this).build()
baseComponent.inject(this)


//MODULARIZED - 2.11 add BaseComponent in AppComponentBuilder
@Component.Builder
interface Builder {

	@BindsInstance
		fun applicationContext(application: Application): Builder
		fun baseComponent(baseComponent: BaseComponent): Builder
		fun build(): AppComponent
	}
}

//MODULARIZED - 2.12 add baseComponent and passing baseComponent from parent class
val appApplication = DaggerAppComponent.builder().applicationContext(this).baseComponent(
    baseComponent
).build()