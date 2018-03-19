<?xml version = "1.0"?>
<xsl:stylesheet xmlns:xsl = "http://www.w3.org/1999/XSL/Transform" version = "1.0">
 
   <xsl:output method = "html" indent = "yes"/>
   <xsl:template match = "/">
      <html>
         <body>
            <xsl:apply-templates/>
         </body>
      </html>
   </xsl:template>
    
   <xsl:template match = "cuotas">
   <div class="container-fluid w-75 ">
      <table class="table table-bordered">
        <tr>
            <th style="text-align:center">Dias</th>
            <th style="text-align:center">Crossfit</th>
            <th style="text-align:center">Cycling</th>
            <th style="text-align:center">Natacion</th>
            <th style="text-align:center">Zumba</th>
            <th style="text-align:center">Step</th>
            <th style="text-align:center">Pilates</th>
        </tr>
         <xsl:for-each select = "cuota">
            <tr>
                <td style="text-align:center">
                  <i><xsl:value-of select = "dias"/></i>
               </td>
               <td style="text-align:center">
                  <i><xsl:value-of select = "crossfit"/></i>
               </td>
               
               <td style="text-align:center">
                  <xsl:value-of select = "cycling"/>
               </td>
               
               <td style="text-align:center">
                  <xsl:value-of select = "natacion"/>
               </td>
               
               <td style="text-align:center">
                  <xsl:value-of select = "zumba"/>
               </td>
               
               <td style="text-align:center">
                  <xsl:value-of select = "step"/>
               </td>
               
               <td style="text-align:center">
                  <xsl:value-of select = "pilates"/>
               </td>
            </tr>
         </xsl:for-each>
      </table>
   </div>
   
   </xsl:template>
</xsl:stylesheet>