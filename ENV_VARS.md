# Required Environment Variables (set these on Render/Railway, not in code)

| Variable | Example | Notes |
|---|---|---|
| MONGODB_URI | mongodb+srv://user:pass@cluster.mongodb.net/portfolio_cms | Use MongoDB Atlas for production, not local Mongo |
| JWT_SECRET | (generate a new long random string) | Must be different from the dev default — see below |
| ADMIN_USERNAME | your-admin-name | |
| ADMIN_PASSWORD | (strong password) | Must be different from the dev default |
| CORS_ALLOWED_ORIGINS | https://your-portfolio.vercel.app,https://your-admin.vercel.app | Comma-separated, no spaces, set AFTER frontend deploys and you know the real URLs |
| MAIL_USERNAME | you@gmail.com | optional, for contact form emails |
| MAIL_PASSWORD | (Gmail App Password) | optional |
| CONTACT_NOTIFY_EMAIL | you@gmail.com | optional |



> Each person running this project needs their own MongoDB instance and,
> optionally, their own Gmail App Password for contact-form emails.
> ADMIN_USERNAME/ADMIN_PASSWORD can be anything you choose — it creates
> your own admin account on first run.