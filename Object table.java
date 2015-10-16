//pool table ball prototyping
//Nick Ferro
//10-16-2016


Ball red;
float left, right, top, bottom;
float middle;


void setup() {
  size( 600, 400 );
  left=   50;
  right=  width-50;
  top=    100;
  bottom= height-50;
  middle= left + (right-left) / 2;
  red = new Ball(width/2, height/2, 1, 1);
  //reset();
 }
 
 void draw() {
  background( 250,250,200 );
  rectMode( CORNERS );
  table( left, top, right, bottom );
  red.bounce();
  red.show();
 }
 
 void table( float left, float top, float right, float bottom ) {
  fill( 100, 250, 100 );    // green pool table
  strokeWeight(20);
  stroke( 127, 0, 0 );      // Brown walls
  rect( left-20, top-20, right+20, bottom+20 );
  stroke(0);
  strokeWeight(1);
}
 
 
class Ball {
  float x,y,dx,dy;
  
  Ball(float tempX, float tempY, float tempDX, float tempDY){
    x = tempX;
    y = tempY;
    dx = tempDX;
    dy = tempDY;
  }
  
  void bounce(){
    x += dx;  if ( x<left || x>right ) dx *= -1;
    y += dy;  if ( y<top || y>bottom ) dy *=  -1;
  }
  
  void show(){
    fill( 255,0,0 );    
    ellipse( x,y, 30,30 );
  }
}
