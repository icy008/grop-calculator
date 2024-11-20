/** @type {import('tailwindcss').Config} */
export default {
  content: ["./frontend/views/index.html", "./src/**/*.{js,ts,jsx,tsx}",],
  theme: {
    extend: {
      colors:{
        "primary-color": "var(--lumo-primary-color)",
        "primary-color-50pct": "var(--background-color)",
        "primary-color-100pct": "#DCE4C9",
        "primary-color-150pct": "#ABBA7C",
      }
    },
  },
  plugins: [],
}



