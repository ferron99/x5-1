float redX, redY, redDX, redDY;

void setup(){
  size(600,600);
  reset();
}

void reset(){
  redX=400; redY=400;
  redDX=  random( -5,5 );   redDY=  random( -5,5 );
}

void draw(){
 background( 250,250,200 );
 table();
 bounce();
 show();
}

void table(){
  noStroke();
  fill( 100, 250, 100 );
  rect(width/2, 50, 250, 500);
  rect(50, 300, 250,250);
}

void bounce(){
  redX += redDX;
  if (redX>535) redDX *= -1;
  if (redX<65 && redY>315) redDX *= -1;
  if (redX<315 && redY<315) redDX *= -1;
  redY += redDY;
  if (redY>535) redDY *= -1;
  if (redY<65 && redX>315) redDY *= -1;
  if (redY<315 && redX<315) redDY *= -1;
}

void show() {
  stroke(0);
  fill( 255,0,0 );    ellipse( redX,redY, 30,30 );
}


void keyPressed() {
  if (key == 'r') {
    reset();
  }
}
