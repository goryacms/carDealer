package com.company.cardealer.web.carpurchaserequest;

import com.company.cardealer.entity.CarPurchaseRequest;
import com.company.cardealer.entity.ProcAttachment;
import com.company.cardealer.service.CarPurchaseRequestService;
import com.haulmont.bpm.gui.procactions.ProcActionsFrame;
import com.haulmont.cuba.gui.app.core.file.FileDownloadHelper;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.TextField;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

public class CarPurchaseRequestEdit extends AbstractEditor<CarPurchaseRequest> {
    private static final String PROCESS_CODE = "carPurchaseRequestApproval";

    @Inject
    private ProcActionsFrame procActionsFrame;

    @Inject
    private Table<ProcAttachment> attachmentsTable;

    @Named("fieldGroup.tax")
    private TextField taxField;

    @Named("fieldGroup.amount")
    private TextField amountField;

    @Inject
    private CarPurchaseRequestService carPurchaseRequestService;

    @Override
    protected void postInit() {
        super.postInit();

        FileDownloadHelper.initGeneratedColumn(attachmentsTable, "file");
        initProcActionsFrame();

        amountField.addValueChangeListener(it -> {
            BigDecimal amount = getItem().getAmount();
            BigDecimal resultTax = carPurchaseRequestService.getTaxRate(amount);
            taxField.setValue(resultTax);
            getItem().setTax(resultTax);
        });
    }

    private void initProcActionsFrame() {
        procActionsFrame.initializer()
                .setBeforeCancelProcessPredicate(this::commit)
                .setAfterStartProcessListener(() -> {
                    showNotification(getMessage("processStarted"), NotificationType.HUMANIZED);
                    close(COMMIT_ACTION_ID);
                })
                .setBeforeCompleteTaskPredicate(this::commit)
                .setAfterCompleteTaskListener(() -> {
                    showNotification(getMessage("taskCompleted"), NotificationType.HUMANIZED);
                    close(COMMIT_ACTION_ID);
                })
                .init(PROCESS_CODE, getItem());
    }
}