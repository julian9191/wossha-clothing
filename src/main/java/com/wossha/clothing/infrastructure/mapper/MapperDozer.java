package com.wossha.clothing.infrastructure.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import com.wossha.clothing.commands.createClothe.model.Clothe;
import com.wossha.clothing.dto.ClotheDTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MapperDozer {

    protected static Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

    static {
        ArrayList<String> mappingfileUrls = new ArrayList<>();
        mappingfileUrls.add("dozer/dozerClothingMapping.xml");
        ((DozerBeanMapper) mapper).setMappingFiles(mappingfileUrls);
    }

    public <T> T map(Object source, Class<T> destinationClass){
        return mapper.map(source, destinationClass);
    }

    public ClotheDTO mapClotheDTOToClothe(Clothe cl){
        return mapper.map(  cl,  ClotheDTO.class);
    }

    /*public DocumentoSolicitudRecord mapDocumentoSolicitudRecord(DocumentoSolicitud dc){
        return mapper.map(  dc,  DocumentoSolicitudRecord.class);
    }

    public BandejaCobroRecord mapBandejaCobroRecord(SolicitudCobroRechazado solicitudCobroRechazado) {
        return mapper.map(solicitudCobroRechazado, BandejaCobroRecord.class);
    }

    public BandejaCobroRecord mapBandejaCobroRecord(SolicitudFaltanDocumentosNecesariosCobro solicitudFaltanDocumentosNecesariosCobro) {
        return mapper.map(solicitudFaltanDocumentosNecesariosCobro, BandejaCobroRecord.class);
    }

    public BandejaCobroRecord mapBandejaCobroRecord(CobroPrevisionalDetenido cobroPrevisionalDetenido) {
        return mapper.map(cobroPrevisionalDetenido, BandejaCobroRecord.class);
    }

    public BandejaCobroRecord mapBandejaCobroRecord(TutelaNormalizablePendienteCobro tutelaNormalizablePendienteCobro) {
        return mapper.map(tutelaNormalizablePendienteCobro, BandejaCobroRecord.class);
    }
    public BandejaCobroRecord mapBandejaCobroRecord(SitTutelaRegistrada sitTutelaRegistrada) {
        return mapper.map(sitTutelaRegistrada, BandejaCobroRecord.class);
    }

    public BandejaCobroRecord mapBandejaCobroRecord(SolicitudPagoInferiorAlCobrado solicitudPagoInferiorAlCobrado) {
        return mapper.map(solicitudPagoInferiorAlCobrado, BandejaCobroRecord.class);
    }

    public BandejaCobroRecord mapBandejaCobroRecord(SolicitudSinIBC solicitudSinIBC) {
        return mapper.map(solicitudSinIBC, BandejaCobroRecord.class);
    }

    public BandejaCobroRecord mapBandejaCobroRecord(SolicitudSinSaldoNecesario solicitudSinSaldoNecesario) {
        return mapper.map(solicitudSinSaldoNecesario, BandejaCobroRecord.class);
    }

    public BandejaCobroRecord mapBandejaCobroRecord(SolicitudConSaldoPorReintegrar solicitud) {
        return mapper.map(solicitud, BandejaCobroRecord.class);
    }

    public GuionRecord mapGuionRecord(co.com.proteccion.advance.it.eventos.events.tutelas.normalizada.Mensaje mensaje) {
        return mapper.map(mensaje, GuionRecord.class);
    }

    public BandejaCobroRecord mapBandejaCobroRecord(ReintegroPrevisionalRechazado solicitud) {
        return mapper.map(solicitud, BandejaCobroRecord.class);
    }

    public InformacionPagoSitRecord mapInformacioPagoSit(InformacionPagoSit infoPagoSit) {
        return mapper.map(infoPagoSit, InformacionPagoSitRecord.class);
    }

    public IbcSolicitudRecord mapInformacionIbc(InformacionIbc infoIbc) {
        return mapper.map(infoIbc, IbcSolicitudRecord.class);
    }

    public Solicitud mapSolicitud(Mensaje mensaje, Solicitud solicitud) {
        Solicitud s = solicitud.copy();
        mapper.map(mensaje, s);
        return s;
    }

    public List<IncapacidadME> mapIncapacidadesAutorizadas(List<co.com.proteccion.advance.it.eventos.events.ipr.IncapacidadME> incapacidades) {
        return incapacidades.stream().map(x -> mapper.map(x, co.com.proteccion.advance.it.eventos.events.sit.incapacidadesautorizadas.IncapacidadME.class)).collect(Collectors.toList());
    }

    public PagoPrevisionalME mapPagoPrevisional(RegistroPagoPrevisionalDTO x) {
        PagoPrevisionalME pago = new PagoPrevisionalME();
        pago.setNumeroSolicitud(x.getUuidSolicitud());
        pago.setTipoIdentificacion(x.getTipoIdentificacion());
        pago.setNumeroIdentificacion(x.getNroIdentificacion());
        return pago;
    }

    public co.com.proteccion.advance.it.eventos.events.sit.previsional.aprobado.PagoPrevisionalME mapPagoPrevisional2(RegistroPagoPrevisionalDTO x) {
        co.com.proteccion.advance.it.eventos.events.sit.previsional.aprobado.PagoPrevisionalME pago = new co.com.proteccion.advance.it.eventos.events.sit.previsional.aprobado.PagoPrevisionalME();
        pago.setNumeroSolicitud(x.getUuidSolicitud());
        pago.setTipoIdentificacion(x.getTipoIdentificacion());
        pago.setNumeroIdentificacion(x.getNroIdentificacion());
        return pago;
    }

    public co.com.proteccion.advance.it.eventos.events.sit.previsional.recibido.Vigencia mapVigencia (VigenciaRecord vigenciaRecord){
        return mapper.map(vigenciaRecord, co.com.proteccion.advance.it.eventos.events.sit.previsional.recibido.Vigencia.class);
    }

    public co.com.proteccion.advance.it.eventos.events.sit.previsional.aprobado.Vigencia mapVigenciaCargado (VigenciaRecord vigenciaRecord){
        return mapper.map(vigenciaRecord, co.com.proteccion.advance.it.eventos.events.sit.previsional.aprobado.Vigencia.class);
    }

    public co.com.proteccion.advance.it.eventos.events.sit.previsional.ajuste.Vigencia mapVigenciaAjuste(VigenciaRecord vigenciaRecord) {
        return mapper.map(vigenciaRecord, co.com.proteccion.advance.it.eventos.events.sit.previsional.ajuste.Vigencia.class);
    }

    public VigenciaDTO mapVigenciaDTO(VigenciaRecord vigenciaRecord) {
        VigenciaDTO dto = new VigenciaDTO(
                vigenciaRecord.getId(),
                vigenciaRecord.getOrigenPrevisional(),
                vigenciaRecord.getNombreCorto(),
                vigenciaRecord.getNit(),
                vigenciaRecord.getCuentaDebitoCobro(),
                vigenciaRecord.getCuentaCreditoCobro(),
                vigenciaRecord.getCuentaDebitoPago(),
                vigenciaRecord.getCuentaCreditoPago(),
                vigenciaRecord.getFechaInicio(),
                vigenciaRecord.getFechaFin(),
                vigenciaRecord.getTipoEnvioDocumentos(),
                vigenciaRecord.getMedioEnvioDocumentos(),
                vigenciaRecord.getNormalizaTutelas() ? "Si" : "No"
        );
        return dto;
    }*/
}
