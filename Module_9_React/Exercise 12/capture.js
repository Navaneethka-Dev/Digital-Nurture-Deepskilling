const puppeteer = require('puppeteer');

(async () => {
  try {
    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    await page.setViewport({ width: 1024, height: 768 });
    
    // Go to Exercise 12 app
    await page.goto('http://localhost:3000', { waitUntil: 'networkidle2' });
    
    // Take screenshot of Guest Page
    await page.screenshot({ path: 'guest_page.png' });
    console.log('Saved guest_page.png');
    
    // Click Login button
    await page.evaluate(() => {
      const buttons = Array.from(document.querySelectorAll('button'));
      const loginBtn = buttons.find(b => b.textContent.includes('Login'));
      if (loginBtn) loginBtn.click();
    });
    
    // Wait for render
    await new Promise(r => setTimeout(r, 1000));
    
    // Take screenshot of User Page
    await page.screenshot({ path: 'user_page.png' });
    console.log('Saved user_page.png');
    
    await browser.close();
  } catch (error) {
    console.error('Error taking screenshots:', error);
  }
})();
