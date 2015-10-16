//Complex table shape test and elastic collision with objects of different masses
//Nick Ferro
//10-16-2016

float redX, redY, redDX, redDY;
float yelX,  yelY,  yelDX,  yelDY;
float bluX, bluY, bluDX, bluDY;
float cueX,  cueY,  cueDX,  cueDY;

void setup(){
  size(600,600);
  reset();
}

void reset(){
  redX=400; redY=400;
  yelX=525; yelY=200;
  bluX=375; bluY=200;
  cueX=200; cueY=400;
  redDX=  random( -5,5 );   redDY=  random( -5,5 );
  yelDX=  random( -5,5 );   yelDY=  random( -5,5 );
  bluDX=  random( -5,5 );   bluDY=  random( -5,5 );
  cueDX= 1; cueDY= 1;
}

void draw(){
 background( 250,250,200 );
 table();
 bounce();
 collisions();
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
  if(redY<310){
    if (redX<315 && redY<315) redDX *= -1;
  }
  redY += redDY;
  if (redY>535) redDY *= -1;
  if (redY<65 && redX>315) redDY *= -1;
  if(redX<310){
    if (redY<315 && redX<315) redDY *= -1;
  }
  yelX += yelDX;
  if (yelX>535) yelDX *= -1;
  if (yelX<65 && yelY>315) yelDX *= -1;
  if(yelY<310){
    if (yelX<315 && yelY<315) yelDX *= -1;
  }
  yelY += yelDY;
  if (yelY>535) yelDY *= -1;
  if (yelY<65 && yelX>315) yelDY *= -1;
  if(yelX<310){
    if (yelY<315 && yelX<315) yelDY *= -1;
  }
   bluX += bluDX;
  if (bluX>531) bluDX *= -1;
  if (bluX<69 && bluY>319) bluDX *= -1;
  if(bluY<310){
    if (bluX<319 && bluY<319) bluDX *= -1;
  }
  bluY += bluDY;
  if (bluY>531) bluDY *= -1;
  if (bluY<69 && bluX>319) bluDY *= -1;
  if(bluX<310){
    if (bluY<319 && bluX<319) bluDY *= -1;
  }
   cueX += cueDX;
  if (cueX>535) cueDX *= -1;
  if (cueX<65 && cueY>315) cueDX *= -1;
  if(cueY<310){
    if (cueX<315 && cueY<315) cueDX *= -1;
  }
  cueY += cueDY;
  if (cueY>535) cueDY *= -1;
  if (cueY<65 && cueX>315) cueDY *= -1;
  if(cueX<310){
    if (cueY<315 && cueX<315) cueDY *= -1;
  }
}

void collisions() {
  float tmp;
  // Swap velocities!
  if ( dist( redX,redY, yelX,yelY ) < 30 ) {         //yellow and red
    tmp=yelDX;  yelDX=redDX;  redDX=tmp;
    tmp=yelDY;  yelDY=redDY;  redDY=tmp;
  }
  if ( dist( bluX,bluY, yelX,yelY ) < 34 ) {         //yellow and blu
    tmp=yelDX;  yelDX=bluDX*2;  bluDX=tmp/2;
    tmp=yelDY;  yelDY=bluDY*2;  bluDY=tmp/2;
  }
  if ( dist( redX,redY, bluX,bluY ) < 34 ) {         //blu and red
    tmp=bluDX;  bluDX=redDX/2;  redDX=tmp*2;
    tmp=bluDY;  bluDY=redDY/2;  redDY=tmp*2;
  }
  if ( dist( redX,redY, cueX,cueY ) < 30 ) {         //cue and red
    tmp=cueDX;  cueDX=redDX;  redDX=tmp;
    tmp=cueDY;  cueDY=redDY;  redDY=tmp;
  }
  if ( dist( cueX,cueY, yelX,yelY ) < 30 ) {         //cue and yel
    tmp=cueDX;  cueDX=yelDX;  yelDX=tmp;
    tmp=cueDY;  cueDY=yelDY;  yelDY=tmp;
  }
  if ( dist( cueX,cueY, bluX,bluY ) < 34 ) {         //cue and blu
    tmp=bluDX;  bluDX=cueDX/2;  cueDX=tmp*2;
    tmp=bluDY;  bluDY=cueDY/2;  cueDY=tmp*2;
  }
}

void show() {
  stroke(0);
  fill( 255,0,0 );    ellipse( redX,redY, 30,30 );
  fill( 255,255,0 );  ellipse( yelX,yelY, 30,30 );
  fill( 0,0,255 );    ellipse( bluX,bluY, 38,38 );
  fill( 255,255,255 );    ellipse( cueX,cueY, 30,30 );
}


void keyPressed() {
  if (key == 'r') {
    reset();
  }
}
