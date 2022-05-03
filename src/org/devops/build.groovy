package org.devops
//构建类型
def Build(buildType,buildShell){
  def buildTools = ["mvn":"M2","ant":"A2","gradle":"G2","npm":"N2"]
  println("当前选择的构建类型 为${buildShell}")
  buildHome = tool buildTools[buildType]
  sh "${buildHome}/bin/${buildType} ${buildShell}"
}
