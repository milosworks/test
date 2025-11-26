import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea

    alias(libs.plugins.cloche)

    alias(libs.plugins.kotlin.jvm)
}

repositories {
    cloche.librariesMinecraft()

    mavenCentral()
    google()

//    exclusiveContent {
//        forRepository {
//            maven("https://api.modrinth.com/maven") { name = "Modrinth" }
//        }
//        filter { includeGroup("maven.modrinth") }
//    }
//
    maven("https://thedarkcolour.github.io/KotlinForForge/") { name = "KFF" }
    maven("https://maven.architectury.dev/") { name = "Architectury " }
//    maven("https://maven.teamresourceful.com/repository/maven-public/") { name = "Terrarium" }

    cloche {
        main()

        mavenNeoforged()
        mavenNeoforgedMeta()
        mavenFabric()

        mavenParchment()
    }
}

dependencies {
    implementation(libs.klib)
}

cloche {
    metadata {
        val id: String by project
        val modName: String by project
        val license: String by project
        val description: String by project
        val authors: String by project

        modId = id
        name = modName
        this.license = license
        this.description = description

        authors.split(',').map { it.trim() }.forEach { author(it) }
    }

    minecraftVersion = libs.versions.minecraft.get()

    mappings {
        official()
        parchment(libs.versions.parchment.get())
    }

    common {
        dependencies {
//            modImplementation(libs.klib)
//            modImplementation("earth.terrarium.common_storage_lib:common-storage-lib-common-1.21.1:0.0.7")
        }
    }

    neoforge {
        loaderVersion = libs.versions.neoforge.loader.get()

        metadata {
            modLoader = "kotlinforforge"
            loaderVersion("5")

            dependency("kotlinforforge", libs.versions.kotlin.neoforge.get())
        }

        dependencies {
//            modImplementation(libs.kotlin.neoforge)
//            modImplementation(libs.architectury.neoforge)

//            modImplementation(libs.jade) {
//                version { strictly("${libs.versions.jade.get()}+neoforge") }
//            }
        }

//        data()
//
//        runs {
//            data()
//        }
    }

    fabric {
        loaderVersion = libs.versions.fabric.loader.get()

        includedClient()

        metadata {
            entrypoint("main") {
                value = "xyz.milosworks.untitled.fabric.UntitledFabric"
                adapter = "kotlin"
            }
            entrypoint("client") {
                value = "xyz.milosworks.untitled.fabric.UntitledFabric"
                adapter = "kotlin"
            }

            dependency("fabric-language-kotlin", libs.versions.kotlin.fabric.get())
        }

        dependencies {
            fabricApi(libs.versions.fabric.api.get())

            modImplementation(libs.kotlin.fabric)

//            modImplementation(libs.architectury.fabric)

//            modImplementation(libs.jade) {
//                version { strictly("${libs.versions.jade.get()}+fabric") }
//            }
        }
    }

    targets.all {
        dependencies {
//            modImplementation("earth.terrarium.common_storage_lib:common-storage-lib-$loaderName-${minecraftVersion.get()}:0.0.7")
        }

        runs {
            client {
                arguments.addAll("--username", "Vyrek_", "--quickPlaySingleplayer", "Test")
            }
        }
    }
}

kotlin {
    jvmToolchain(21)
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        freeCompilerArgs.addAll(
            "-Xmulti-platform",
            "-Xno-check-actual",
            "-Xexpect-actual-classes",
        )
    }
}