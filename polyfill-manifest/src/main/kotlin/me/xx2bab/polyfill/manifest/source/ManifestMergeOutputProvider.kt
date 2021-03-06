package me.xx2bab.polyfill.manifest.source

import com.android.build.api.artifact.ArtifactType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.variant.Variant
import me.xx2bab.polyfill.matrix.base.ApplicationSelfManageableProvider
import org.gradle.api.Project
import org.gradle.api.file.RegularFile

class ManifestMergeOutputProvider: ApplicationSelfManageableProvider<RegularFile> {

    private lateinit var mergedManifests: RegularFile

    override fun initialize(project: Project,
                            androidExtension: CommonExtension<*, *, *, *, *, *, *, *>,
                            variant: Variant) {
        mergedManifests = variant.artifacts.get(ArtifactType.MERGED_MANIFEST).get()
//        val t = project.tasks.withType(ProcessApplicationManifest::class.java)
//        mergedManifests = t.first().mergedManifest.get()
    }

    override fun get(defaultValue: RegularFile?): RegularFile? {
        return mergedManifests
    }

    override fun isPresent(): Boolean {
        return ::mergedManifests.isInitialized
    }

}