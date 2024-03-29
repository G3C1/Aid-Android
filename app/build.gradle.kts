import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
    kotlin("kapt")
}

android {
    compileSdk = Versions.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = "com.g3c1.oasis_android"
        minSdk = Versions.MIN_SDK_VERSION
        targetSdk = Versions.TARGET_SDK_VERSION
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField(
            "String",
            "BASE_URL",
            getApiKey("BASE_URL")
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Versions.JAVA_VERSION
        targetCompatibility = Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.APP_COMPAT)
    implementation(Dependency.Compose.COMPOSE)
    implementation(Dependency.Compose.COMPOSE_MATERAIL)
    implementation(Dependency.Compose.COMPOSE_PREVIEW)
    implementation(Dependency.AndroidX.LIFECYCLE_RUNTIME)
    implementation(Dependency.AndroidX.ACTIVITY_COMPOSE)
    implementation(Dependency.FireBase.FIRESTORE)
    testImplementation(Dependency.UnitTest.JUNIT)
    implementation(Dependency.Google.HILT_ANDROID)
    kapt(Dependency.Google.HILT_ANDROID_COMPILER)
    androidTestImplementation(Dependency.AndroidTest.ANDROID_JUNIT)
    androidTestImplementation(Dependency.AndroidTest.ESPRESSO_CORE)
    androidTestImplementation(Dependency.ComposeTest.COMPOSE_TEST)
    debugImplementation(Dependency.Compose.COMPOSE_TOOLING)
    implementation(Dependency.Compose.COMPOSE_NAV)

    implementation(Dependency.Libraries.RETROFIT)
    implementation(Dependency.Libraries.RETROFIT_CONVERTER_GSON)
    implementation(Dependency.Libraries.OKHTTP)

    implementation(Dependency.Coroutine.COROUTINE)

    implementation(Dependency.ImageLoad.COIL)

    implementation(Dependency.FireBase.FIREBASE_ANALYTICS)
    implementation(platform(Dependency.FireBase.FIREBASE_BOM))
    implementation(Dependency.Compose.COMPOSE_LIVEDATA)

    implementation(Dependency.Google.SYSTEM_UI_CONTROLLER)

    implementation(Dependency.AndroidX.CAMERA)
    implementation(Dependency.AndroidX.CAMERA_LIFECYCLE)
    implementation(Dependency.AndroidX.CAMERA_VIEW)
    implementation(Dependency.Google.ZXING)

    implementation(Dependency.AndroidX.DATASTORE)
    implementation(Dependency.AndroidX.DATASTORE_CORE)
    implementation(Dependency.AndroidX.DATASTORE_CORE)

    implementation(Dependency.DataStore.PREFERENCES)
    implementation(Dependency.DataStore.PREFERENCES_CORE)

}

fun getApiKey(propertyKey: String): String {
    val propFile = rootProject.file("./local.properties")
    val properties = Properties()
    properties.load(FileInputStream(propFile))
    return properties.getProperty(propertyKey)
}