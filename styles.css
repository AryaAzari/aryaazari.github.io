/* RESET */
*,*::before,*::after{box-sizing:border-box}
*{margin:0}
html:focus-within{scroll-behavior:smooth}
body{min-height:100vh;text-rendering:optimizeLegibility;line-height:1.6}
img,picture,svg,video,canvas{max-width:100%;display:block}
input,button,textarea,select{font:inherit}

/* THEME */
:root {
  --bg:#0b1020;--surface:#0f172a;--card:#111827;
  --text:#e5e7eb;--muted:#94a3b8;
  --brand:#0ea5e9;--brand-2:#a78bfa;
  --ring:rgba(14,165,233,.5);--shadow:0 10px 30px rgba(2,8,23,.5);
  --radius:18px;--glass:rgba(255,255,255,.06);
  --border:1px solid rgba(148,163,184,.15);
}
html[data-theme="light"] {
  --bg:#f8fafc;--surface:#fff;--card:#fff;
  --text:#0f172a;--muted:#475569;
  --brand:#0ea5e9;--brand-2:#7c3aed;
  --ring:rgba(14,165,233,.45);--shadow:0 12px 30px rgba(2,8,23,.08);
  --glass:rgba(2,8,23,.035);--border:1px solid rgba(2,6,23,.08);
}
body{font-family:Inter,system-ui,sans-serif;background:var(--bg);color:var(--text)}

/* UTILS */
.container{width:min(1120px,90vw);margin-inline:auto}
.stack{display:grid;gap:1rem}
.btn{display:inline-flex;align-items:center;gap:.6rem;padding:.8rem 1rem;border-radius:14px;border:var(--border);background:var(--glass);color:var(--text);text-decoration:none;transition:.2s}
.btn:hover{transform:translateY(-2px)}
.btn-primary{background:linear-gradient(135deg,var(--brand),var(--brand-2));color:white;border:none}
.chip{display:inline-flex;align-items:center;gap:.4rem;padding:.35rem .6rem;border-radius:999px;border:var(--border);background:var(--glass);font-size:.85rem;color:var(--muted)}

/* NAV */
.nav{position:sticky;top:0;background:var(--surface)}
.nav-inner{display:flex;justify-content:space-between;align-items:center;padding:1rem 0}
.brand{font-weight:800}.brand span{background:linear-gradient(135deg,var(--brand),var(--brand-2));-webkit-background-clip:text;color:transparent}
.nav-links{display:flex;gap:.6rem}
.nav-links a{padding:.55rem .8rem;border-radius:12px;color:var(--muted);text-decoration:none}
.nav-links a:hover{background:var(--glass);color:var(--text)}
.toggle{width:42px;height:28px;border-radius:999px;background:var(--glass);border:var(--border);position:relative;cursor:pointer}
.toggle span{position:absolute;top:3px;left:3px;width:22px;height:22px;border-radius:50%;background:linear-gradient(135deg,var(--brand),var(--brand-2));transition:.2s}
html[data-theme="dark"] .toggle span{left:17px}

/* HERO */
.hero{padding:6rem 0 4rem;display:grid;grid-template-columns:1.1fr .9fr;gap:3rem;align-items:center}
.title{font-weight:800;font-size:clamp(2.2rem,1.2rem+3.5vw,4rem);line-height:1.1}
.title .grad{background:linear-gradient(135deg,var(--brand),var(--brand-2));-webkit-background-clip:text;color:transparent}
.subtitle{color:var(--muted);font-size:1.1rem;margin:1rem 0}
.preview{aspect-ratio:4/3;border-radius:var(--radius);border:var(--border);background:conic-gradient(from 180deg at 50% 50%,rgba(14,165,233,.25),rgba(124,58,237,.25),rgba(14,165,233,.25))}

/* CARDS */
.grid{display:grid;gap:1rem}
.grid.cols-3{grid-template-columns:repeat(3,1fr)}
.card{background:var(--card);border:var(--border);border-radius:var(--radius);overflow:hidden;display:flex;flex-direction:column;transition:.2s}
.card:hover{transform:translateY(-4px);box-shadow:var(--shadow)}
.thumb{aspect-ratio:16/9;background:linear-gradient(135deg,rgba(14,165,233,.2),rgba(124,58,237,.2))}
.card-body{padding:1rem}
.card h3{margin-bottom:.4rem;font-size:1.1rem}
.card p{color:var(--muted)}

/* ABOUT & CONTACT */
.about{display:grid;grid-template-columns:.9fr 1.1fr;gap:2rem}
.blurb{background:var(--card);border:var(--border);border-radius:var(--radius);padding:1.2rem}
.contact{display:grid;grid-template-columns:1fr 1fr;gap:1.5rem}
.panel{background:var(--card);border:var(--border);border-radius:var(--radius);padding:1.2rem}
form{display:grid;gap:.8rem}
input,textarea{width:100%;padding:.85rem;border-radius:12px;border:var(--border);background:var(--surface);color:var(--text)}
textarea{min-height:120px;resize:vertical}

/* FOOTER */
footer{padding:2rem 0;color:var(--muted)}

/* ANIMATIONS */
.reveal{opacity:0;transform:translateY(16px);transition:.6s}
.reveal.in{opacity:1;transform:translateY(0)}

/* RESPONSIVE */
@media(max-width:960px){.hero{grid-template-columns:1fr}.grid.cols-3{grid-template-columns:1fr 1fr}.about{grid-template-columns:1fr}.contact{grid-template-columns:1fr}}
@media(max-width:640px){.nav-links{display:none}.grid.cols-3{grid-template-columns:1fr}}
