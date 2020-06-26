package io.android.brewdogbeers.plugin

import io.android.brewdogbeers.task.ProjectCodeStyleTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jmailen.gradle.kotlinter.KotlinterExtension
import org.jmailen.gradle.kotlinter.KotlinterPlugin
import org.jmailen.gradle.kotlinter.tasks.LintTask

class QualityPlugin : Plugin<Project> {

    override fun apply(project: Project) = with(project) {
        ProjectCodeStyleTask.applyToRootProject(this)

        configureKtlint()
    }
}

internal fun Project.configureKtlint() {
    pluginManager.apply(KotlinterPlugin::class.java)
    extensions.configure(KotlinterExtension::class.java) {
        it.indentSize = 4
        it.reporters = arrayOf("plain")
        it.experimentalRules = false
        it.disabledRules = arrayOf("import-ordering")
    }
    tasks.withType(LintTask::class.java) {
        rootProject.tasks.named(ProjectCodeStyleTask.TASK_NAME) { projectCodeStyle ->
            projectCodeStyle.dependsOn(it)
        }
    }
}
