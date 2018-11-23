<!DOCTYPE html>
<html><head><meta name="GCD" content="YTk3ODQ3ZWZhN2I4NzZmMzBkNTEwYjJl4ee87b10a05321be28bab81d28d34fa4"/>
  <meta charset="utf-8">
  <title>undefined</title>
  <meta name="generator" content="Google Web Designer 4.2.0.0802">
  <meta name="template" content="Expandable 3.0.0">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="gwdpage_style.css" rel="stylesheet" data-version="12" data-exports-type="gwd-page">
  <link href="gwdpagedeck_style.css" rel="stylesheet" data-version="11" data-exports-type="gwd-pagedeck">
  <style type="text/css" id="gwd-lightbox-style">.gwd-lightbox {
    overflow: hidden;
}</style>
  <style type="text/css" id="gwd-text-style">p {
    margin: 0px;
}
h1 {
    margin: 0px;
}
h2 {
    margin: 0px;
}
h3 {
    margin: 0px;
}</style>
  <style type="text/css">html,
body {
    width: 100%;
    height: 100%;
    margin: 0px;
}
.gwd-page-container {
    position: relative;
    width: 100%;
    height: 100%;
}
.gwd-page-content {
    background-color: transparent;
    transform: matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
    -webkit-transform: matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
    -moz-transform: matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
    perspective: 1400px;
    -webkit-perspective: 1400px;
    -moz-perspective: 1400px;
    transform-style: preserve-3d;
    -webkit-transform-style: preserve-3d;
    -moz-transform-style: preserve-3d;
    position: absolute;
}
.gwd-page-wrapper {
    background-color: rgb(255, 255, 255);
    position: absolute;
    transform: translateZ(0px);
    -webkit-transform: translateZ(0px);
    -moz-transform: translateZ(0px);
}
.page1-content {
    width: 550px;
    height: 400px;
}
.gwd-div-1e2m {
    position: absolute;
    width: 123px;
    height: 54px;
    left: 17px;
    top: 3px;
}
.gwd-div-ne6v {
    position: absolute;
    width: 257px;
    height: 346px;
    left: 3px;
    top: 58px;
}
.gwd-div-gc9e {
    position: absolute;
    width: 280px;
    left: 265px;
    top: 59px;
    height: 325px;
}
.gwd-div-1xqy {
    position: absolute;
    height: 60px;
    width: 240px;
    left: 16px;
    top: 62px;
}
.gwd-div-1ou1 {
    position: absolute;
    top: 128px;
    height: 260px;
    width: 240px;
    left: 16px;
}</style>
  <script data-source="googbase_min.js" data-version="4" data-exports-type="googbase" src="googbase_min.js"></script>
  <script data-source="gwd_webcomponents_min.js" data-version="5" data-exports-type="gwd_webcomponents" src="gwd_webcomponents_min.js"></script>
  <script data-source="gwdpage_min.js" data-version="12" data-exports-type="gwd-page" src="gwdpage_min.js"></script>
  <script data-source="gwdpagedeck_min.js" data-version="11" data-exports-type="gwd-pagedeck" src="gwdpagedeck_min.js"></script>
</head>

<body class="document-body">
  <gwd-pagedeck class="gwd-page-container" id="pagedeck">
    <gwd-page id="page1" class="gwd-page-wrapper page1-content gwd-lightbox" data-gwd-width="550px" data-gwd-height="400px">
      <#include "header.ftlh">
      <div class="gwd-page-content page1-content">
        <div class="gwd-div-1e2m"><#include "logo.ftlh"></div>
        <div class="gwd-div-ne6v"></div>
        <div class="gwd-div-gc9e"></div>
        <div class="gwd-div-1xqy"></div>
        <div class="gwd-div-1ou1"></div>
        <#include "footer.ftlh">
      </div>
    </gwd-page>
  </gwd-pagedeck>
  <script type="text/javascript" id="gwd-init-code">
    (function() {
      document.body.style.opacity = "0";
      var pageDeck = document.getElementById('pagedeck');
      /**
       * Handles the DOMContentLoaded event. The DOMContentLoaded event is
       * fired when the document has been completely loaded and parsed.
       */

      function handleDomContentLoaded(event) {}

      /**
       * Handles the WebComponentsReady event. This event is fired when all
       * custom elements have been registered and upgraded.
       */
      function handleWebComponentsReady(event) {
        document.body.style.opacity = "";
        setTimeout(function() {
          pageDeck.goToPage(pageDeck.getDefaultPage().id);
        }, 0);
      }

      window.addEventListener('DOMContentLoaded',
        handleDomContentLoaded, false);
      window.addEventListener('WebComponentsReady',
        handleWebComponentsReady, false);
    })();
  </script>



</body></html>

