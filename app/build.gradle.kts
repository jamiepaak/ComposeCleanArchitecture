@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApp)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.androidHilt)
    alias(libs.plugins.ksp)
    id("kotlinx-serialization")
}

android {
    namespace = "com.pjh.composebase"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.pjh.composebase"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = "${libs.versions.major.get()}.${libs.versions.minor.get()}.${libs.versions.hotfix.get()}"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compilerVersion.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.serializationJson)

    implementation(libs.coroutines.android)

    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.recyclerView)
    implementation(libs.androidx.constraintLayout)
    implementation(libs.androidx.core)
    implementation(libs.androidx.lifecycle.viewModel)
    implementation(libs.androidx.room)
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.hilt.android)
    ksp(libs.androidx.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.google.material)

    implementation(libs.network.retrofit)
    implementation(libs.network.retrofit.kotlinxSerializationConvert)
    implementation(libs.network.okhttp)
    implementation(libs.network.okhttp.logging)

    implementation(libs.compose.activity)
    implementation(libs.compose.ui)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)
    implementation(libs.compose.runtime)
    implementation(libs.compose.uiToolingPreview)
    implementation(libs.compose.constraintLayout)
    implementation(libs.compose.animation)
    implementation(libs.coil)
    implementation(libs.androidx.lifecycleRuntimeCompose)

    implementation(libs.compose.keyboardState)
    implementation(libs.kotlin.collectionsImmutable)

    debugRuntimeOnly(libs.compose.uiTooling)

    implementation(project(":core:design-system"))
    implementation(project(":core:network"))
    implementation(project(":core:design-system"))
    implementation(project(":core:data:github"))
    implementation(project(":core:domain:github"))
    implementation(project(":core:database:github"))
    implementation(project(":core:database:github-api"))
    implementation(project(":feature:github-search"))

    libs.test.run {
        testImplementation(androidx.core)
        testImplementation(androidx.runner)
        testImplementation(androidx.junit)
        testImplementation(mockito.kotlin)
        testImplementation(junit5)
        testImplementation(junit5.engine)
        testRuntimeOnly(junit5.vintage)
        testImplementation(coroutines)
        testImplementation(coroutines.turbine)
    }
}