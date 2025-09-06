plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    //plugins que yo descargue
    //ksp: procesador de anotaciones para room y las fk
    alias(libs.plugins.ksp)
    //plugin de room que habilita el dsl y crea el tasks tipo room
    id("androidx.room") version "2.7.2"
}

android {
    namespace = "com.example.accounts"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.accounts"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    //dependencias que instale
    //motor sqlite apis base
    implementation(libs.room.runtime)
    //extensiones para movimientos
    implementation(libs.room.ktx)
    //genera daos/entidades  en build/generated/ksp
    ksp(libs.room.compiler)

    //prueba las migraciones, memorias etc
    testImplementation(libs.room.testing)

}

room {
    schemaDirectory("$projectDir/schemas") // ¡versiona esta carpeta!
}
