// Year
document.getElementById('year').textContent = new Date().getFullYear();

// Network nodes animation
const canvas = document.getElementById('networkCanvas');
const ctx = canvas.getContext('2d');
let width, height;

function resize(){
  width = canvas.width = canvas.offsetWidth;
  height = canvas.height = canvas.offsetHeight;
}
window.addEventListener('resize', resize);
resize();

const nodes = Array.from({length:25},()=>({
  x:Math.random()*width,
  y:Math.random()*height,
  dx:(Math.random()-.5)*0.7,
  dy:(Math.random()-.5)*0.7,
  r:2+Math.random()*3
}));

function draw(){
  ctx.clearRect(0,0,width,height);
  // draw links
  for(let i=0;i<nodes.length;i++){
    for(let j=i+1;j<nodes.length;j++){
      const a = nodes[i], b = nodes[j];
      const dist = Math.hypot(a.x-b.x,a.y-b.y);
      if(dist<140){
        ctx.strokeStyle = `rgba(255,255,255,${1-dist/140})`;
        ctx.lineWidth = 1;
        ctx.beginPath();
        ctx.moveTo(a.x,a.y);
        ctx.lineTo(b.x,b.y);
        ctx.stroke();
      }
    }
  }
  // draw nodes
  nodes.forEach(n=>{
    ctx.beginPath();
    ctx.fillStyle = '#fff';
    ctx.arc(n.x,n.y,n.r,0,Math.PI*2);
    ctx.fill();
    n.x+=n.dx; n.y+=n.dy;
    if(n.x<0||n.x>width) n.dx*=-1;
    if(n.y<0||n.y>height) n.dy*=-1;
  });
  requestAnimationFrame(draw);
}
draw();
