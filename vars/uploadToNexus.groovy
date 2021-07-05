def call (mexusRepo) {
  def pom = readMavenPom file: 'pom.xml'
  def artifactId = pom.artifactId
  def groupId = pom.groupId
  def repo = nexusRepo
  nexusArtifactUploader artifacts: [[artifactId: artifactId, classifier: '', file: "target/$(artifactId)-${pom.version}.war", type: 'war']], 
  credentialsId: 'nexus3', 
  groupId: groupId, 
  nexusUrl: '172.31.36.70:8081', 
  nexusVersion: 'nexus3', 
  protocol: 'http', 
  repository: repo, 
  version: pom.version
  
  echo pom.dependencies[0].version
  
}
