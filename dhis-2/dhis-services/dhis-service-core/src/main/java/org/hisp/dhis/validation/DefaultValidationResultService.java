package org.hisp.dhis.validation;
/*
 * Copyright (c) 2004-2017, University of Oslo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.hisp.dhis.validation.comparator.ValidationResultQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Stian Sandvold
 */
@Transactional
public class DefaultValidationResultService
    implements ValidationResultService
{
    @Autowired
    private ValidationResultStore validationResultStore;

    @Override
    public void saveValidationResults( Collection<ValidationResult> validationResults )
    {
        validationResults.forEach( validationResult -> validationResultStore.save( validationResult ) );
    }

    public List<ValidationResult> getAllValidationResults()
    {
        return validationResultStore.getAll();
    }

    @Override
    public List<ValidationResult> getAllUnReportedValidationResults()
    {
        return validationResultStore.getAllUnreportedValidationResults();
    }

    @Override
    public void deleteValidationResult( ValidationResult validationResult )
    {
        validationResultStore.delete( validationResult );
    }

    @Override
    public void updateValidationResults( Set<ValidationResult> validationResults )
    {
        validationResults.forEach( vr -> validationResultStore.update( vr ) );
    }

    @Override
    public ValidationResult getById( int id )
    {
        return validationResultStore.getById( id );
    }

    @Override
    public List<ValidationResult> getValidationResults( ValidationResultQuery query )
    {
        return validationResultStore.query( query );
    }

    @Override
    public int countValidationResults( ValidationResultQuery query )
    {
        return validationResultStore.count( query );
    }
}
