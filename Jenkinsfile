#!groovy
@Library('jenkinslib@master') _
string buildType = "${env.buildType}"
string buildShell = "${env.buildShell}"
def build = new org.devops.build()
pipeline{
	agent  any
	options {
		timestamps()               // 日志会有时间.
		skipDefaultCheckout()            // 删除隐式checkout scm语句
		disableConcurrentBuilds()     // 禁止并行
		timeout(time: 1,unit:'HOURS')  // 流水线超时设置1h
	}
	stages {

		//build
		stage("build"){ //阶段名称
			steps {
				timeout(time:5,unit:"MINUTES"){
					script{ //填写运行代码
						println('选项编译')
						build.Build(buildType,buildShell)
					}
				}
			}
		}
	}
	//构建后操作
	post {
		always {
			script {
				println("always")
			}
		}
		success {
			script {
				currentBuild.description += "\n构建成功"
			}
		}
		failure {
			script {
				currentBuild.description += "\n构建失败"
			}
		}
		aborted {
			script {
				currentBuild.description += "\n构建取消"
			}
		}
	}
}
