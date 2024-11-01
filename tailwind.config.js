/** @type {import('tailwindcss').Config} */
export default {
  content: ["./frontend/views/index.html", "./src/**/*.{js,ts,jsx,tsx}",],
  theme: {
    extend: {
      colors:{
        "primary-color": "var(--lumo-primary-color)",
        "primary-color-50pct": "#E9EFEC",
      }
    },
  },
  plugins: [],
}



