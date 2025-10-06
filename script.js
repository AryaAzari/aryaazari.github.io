const html = document.documentElement;
const toggle = document.getElementById('themeToggle');
const saved = localStorage.getItem('theme');
const prefersDark = window.matchMedia('(prefers-color-scheme: dark)').matches;

if (saved) {
  html.setAttribute('data-theme', saved);
} else {
  html.setAttribute('data-theme', prefersDark ? 'dark' : 'light');
}

toggle?.addEventListener('click', () => {
  const next = html.getAttribute('data-theme') === 'dark' ? 'light' : 'dark';
  html.setAttribute('data-theme', next);
  localStorage.setItem('theme', next);
});

// Reveal on scroll
const revealEls = document.querySelectorAll('.reveal');
const io = new IntersectionObserver((entries) => {
  entries.forEach(e => {
    if (e.isIntersecting) {
      e.target.classList.add('in');
      io.unobserve(e.target);
    }
  });
}, { threshold: 0.12 });
revealEls.forEach(el => io.observe(el));

// Footer year
document.getElementById('year').textContent = new Date().getFullYear();

// Contact form demo
const form = document.getElementById('contactForm');
const msg = document.getElementById('formMsg');
form?.addEventListener('submit', (e) => {
  e.preventDefault();
  const data = Object.fromEntries(new FormData(form).entries());
  const ok = data.name && data.email && data.message;
  msg.style.display = 'block';
  msg.textContent = ok ? 'Thanks! Your message is queued locally (demo).' : 'Please fill out all fields correctly.';
  if (ok) form.reset();
});

// Remove no-js
document.documentElement.classList.remove('no-js');
