package com.ullink.gradle.symstore

import org.gradle.api.GradleException
import org.gradle.api.internal.ConventionTask
import org.gradle.api.tasks.TaskAction

class AddSymbolTask extends ConventionTask {

    String symstorePath

    File file

    String share

    String product

    boolean compress

    @TaskAction
    void run() {
        if(share == null)
            throw new GradleException('share is not set.')

        def command = new CommandBuilder(symstorePath, 'add')
            .withFileArg('f', file?.path)
            .withFileArg('s', share)
            .withArg('t', product)
            .withNoValueArg('compress', compress)
            .build()
        logger.info "Symstore command: $command"
        def info = new StringBuilder()
        def error = new StringBuffer()
        int result = -1
        def shareFile = new File(share)
        if(!shareFile.exists()) {
            shareFile.mkdirs()
        }
        StoreLocker.lock(share) {
            def symstore = command.execute()
            symstore.consumeProcessOutput(info, error)
            result = symstore.waitFor()
        }
        logger.info info.toString()
        logger.error error.toString()
        if(result != 0)
            throw new GradleException("$symstorePath exits with code $result.")
    }
}
