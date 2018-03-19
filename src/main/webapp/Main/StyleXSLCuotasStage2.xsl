<?xml version = "1.0"?>
<xsl:stylesheet xmlns:xsl = "http://www.w3.org/1999/XSL/Transform" version = "1.0">
    
    
    <xsl:template match="table" >
        <div class="container-fluid w-25 ">
        <table class="table table-bordered">
            <tr>
            <th style="text-align:center">Dias</th>
            <th style="text-align:center">Precio</th>
        </tr>
            <xsl:apply-templates/>
        </table> 
        </div>
    </xsl:template>
    
    <xsl:template match="table/row">
       <xsl:variable name="bgcolor">
          <xsl:choose>
              <xsl:when test="(position() mod 2) = 1">linen</xsl:when>
             <xsl:otherwise>white</xsl:otherwise>
          </xsl:choose>
       </xsl:variable>
       <tr bgcolor="white" style="text-align:center">
           <xsl:apply-templates/>
       </tr> 
    </xsl:template>
    <xsl:template match="table/row/cell">
        <td>
            <xsl:apply-templates/>
        </td> 
    </xsl:template>
    
</xsl:stylesheet>