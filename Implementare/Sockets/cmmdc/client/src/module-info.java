module client{
  // Swing
  requires transitive javafx.swing;
  // FX
  requires transitive javafx.controls;
  requires transitive javafx.graphics;
  exports cmmdc.socket.client;
}