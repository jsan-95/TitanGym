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
    
   <xsl:template match = "horarios">
   <div class="container-fluid w-75">
      <table class="table table-striped" border = "1">
          <tr>
              <th style="text-align:left">Hora</th>
              <th style="text-align:left">Lunes</th>
              <th style="text-align:left">Martes</th>
              <th style="text-align:left">Miercoles</th>
              <th style="text-align:left">Jueves</th>
              <th style="text-align:left">Viernes</th>
            </tr>
         <xsl:for-each select = "horario">
            <tr>
               <td>
                  <i><xsl:value-of select = "hora"/></i>
               </td>
               
               <td>
                  <xsl:value-of select = "lunes"/>
               </td>
               
               <td>
                  <xsl:value-of select = "martes"/>
               </td>
               
               <td>
                  <xsl:value-of select = "miercoles"/>
               </td>
               
               <td>
                  <xsl:value-of select = "jueves"/>
               </td>
               
               <td>
                  <xsl:value-of select = "viernes"/>
               </td>
            </tr>
         </xsl:for-each>
      </table>
   </div>
   
   </xsl:template>
</xsl:stylesheet>