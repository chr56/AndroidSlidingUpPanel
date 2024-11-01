plugins {
    alias(libs.plugins.androidGradlePluginLibrary)
    // alias(libs.plugins.kotlin.android)

    // alias(libs.plugins.kotlin.serialization)
    // alias(libs.plugins.kotlin.parcelize)
    // alias(libs.plugins.kotlin.ksp)

    id("maven-publish")
    // id("signing")
}

val libVersion = "1.0"

android {
    compileSdk = 35
    buildToolsVersion = "35.0.0"

    defaultConfig {
        minSdk = 14
        namespace = "com.sothree.slidinguppanel.library"

        consumerProguardFiles("consumer-rules.pro")

        aarMetadata {
            minCompileSdk = 14
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

//    kotlinOptions {
//        jvmTarget = "1.8"
//    }

    publishing {
        publishing {
            singleVariant("release") {
                withSourcesJar()
            }
        }
    }

    buildFeatures {
        buildConfig = false
        // viewBinding = true
        // compose = true
    }
}

dependencies {
    implementation(libs.androidx.recyclerview)
}

publishing {
    publications {
        create<MavenPublication>("release") {

            afterEvaluate {
                from(components["release"])
            }

            groupId = "io.github.chr56"
            artifactId = "android-sliding-up-panel"
            version = libVersion


            pom {
                name.set("Android Sliding Up Panel")
                url.set("https://github.com/chr56/AndroidSlidingUpPanel")

                licenses {
                    license {
                        name.set("Apache-2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0")
                    }
                }
                developers {
                    developer {
                        id.set("chr_56")
                        name.set("chr_56")
                    }
                }
                scm {
                    connection.set("https://github.com/chr56/AndroidSlidingUpPanel.git")
                    developerConnection.set("https://github.com/chr56/AndroidSlidingUpPanel.git")
                    url.set("https://github.com/chr56/AndroidSlidingUpPanel")
                }
            }
        }
    }
}

/*
val secretPropsFile = rootProject.file("secrets.properties")
var secrets = Properties()
if (secretPropsFile.exists()) {
    secretPropsFile.inputStream().use {
        secrets.load(it)
    }
}
if (secretPropsFile.exists()) {
    signing {
        sign(publishing.publications)
        val key = File(secrets["signing_file"] as String).readText()
        useInMemoryPgpKeys(
            secrets["signing_key"] as String,
            key,
            secrets["signing_password"] as String
        )
    }
}
 */