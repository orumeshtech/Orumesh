# Orumesh
## Building OruMesh on Ubuntu 16.04
<ol> 
  <li>Clone the repo on your hard disk</li>
  <li>Install gradle from <a href="https://gradle.org/install"> here </a> </li>
  <li>Open up the terminal</li>
  <li>Switch to cloned directory</li>
  <li>Type "gradle build"</li>
  <li>Type "gradle fatJar"</li>
  <li>Cd to /build/libs</li>
  <li>Type in the commands</li>
    <ul>
      <li>java -jar OruMesh-1.0-SNAPSHOT-all.jar</li>
      <ul>
        <li>-p {tcp_port_number}</li>
        <li>-u {udp_port_number}</li>
        <li>-n <'udp://my.neighbour.1:{port_number_neighbour1}','udp://my.neighbour.2:{port_number_neighbour2}'></li>
        <li>--testnet false</li>
      <ul>
    </ul>
</ol>
