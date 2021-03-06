# Gradle symstore plugin

This plugin allows to execute symstore provided by Windows Software Development Kit.

## Deprecation

Prefer the usage of [symbols server](https://github.com/reeflog/symbols_server) together with its [gradle plugin](https://github.com/reeflog/gradle-symstoreserver-plugin).

## Samples usage

    buildscript {
        dependencies {
            classpath group: 'com.ullink.gradle', name: 'gradle-symstore-plugin', version: '0.2'
        }
    }
    
    apply plugin: 'symstore'
    
    addSymbol {
        // Product name, project.name by default, required
        product = 'my_product'
        // Path to symstore.exe, required
        symstorePath = /C:\Program Files (x86)\Windows Kits\8.1\Debuggers\x64\symstore.exe/
        // Path of files or directories to add, required
        file = 'bin/Release/'
        // Root directory for the symbol store, required
        share = '\\\\sharing\\symbols'
        // Symbols will be compressed, by default false, optional
        compress = true
        // By default product.version, optional
        version = '1.0.0'
        // By default the user and the machine, optional
        comments = 'personal comments'
    }


#See also

## Microsoft documentation

[SymStore Command-Line Options](https://msdn.microsoft.com/fr-fr/library/windows/desktop/ms681378(v=vs.85).aspx) - Full command line documentation

[Using SymStore](https://msdn.microsoft.com/en-us/library/windows/desktop/ms681417(v=vs.85).aspx) - Examples and other information about the usage of Symstore.exe

[Windows SDK for Windows 8.1](https://developer.microsoft.com/en-us/windows/downloads/windows-8-1-sdk) - Page to download the SDK

# License

Plugin licensed under the Apache License, Version 2.0 with no warranty (expressed or implied) for any purpose.
