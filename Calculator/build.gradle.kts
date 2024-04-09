plugins {
 id 'com.zeroc.gradle.ice-builder.slice' version '1.5.0' apply false
}
 
subprojects {
 //
 // Apply Java and Ice Builder plug-ins to all sub-projects
 //
 apply plugin: 'java'
 apply plugin: 'com.zeroc.gradle.ice-builder.slice'
 //
 // Both Client and Server projects share the Printer.ice Slice definitions
 //
 slice {
 java {
 files = [file("../cal.ice")]
 }
 }
 //
 // Use Ice JAR files from maven central repository
 //
 repositories {
 mavenCentral()
 }
 //
 // Both Client and Server depend only on Ice JAR
 //
 dependencies {
 implementation 'com.zeroc:ice:3.7.2'
 }
 //
 // Create a JAR file with the appropriate Main-Class and Class-Path attributes
 //
 jar {
 manifest {
 attributes(
 "Main-Class": project.name.capitalize(),
 "Class-Path": configurations.runtimeClasspath.resolve().collect { it.toURI() }.join(' ')
 )
 }
 }
}