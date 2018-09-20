#!/usr/bin/env groovy

/**
 * @ Maintainer sudheer veeravalli<veersudhir83@gmail.com>
 * Lists all plugins and optionally filters out any blue ocean plugins if not needed
 */
 
def plugins = Jenkins.instance.pluginManager.plugins
allPlugins = plugins.collect{it}
allPlugins = allPlugins.sort()
def finalList = []
for(String item in allPlugins) {
  //if (item.indexOf("blue", 0) < 0) { // enable this condition to filter out any blue ocean plugins
    finalList.add(item.substring(7))
  //}
}
print finalList
